package com.example.essentials.service.business;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicLong;

import com.example.essentials.service.SequenceService;

import jakarta.inject.Named;

/**
 * 
 * @author Binnur Kurt
 *
 */
@Named
public class SequenceServiceImpl implements SequenceService {
	private Map<String, AtomicLong> sequences = new ConcurrentHashMap<String, AtomicLong>();

	@Override
	public long nextId(String sequenceName) {
		return getAtomicLong(sequenceName).incrementAndGet();
	}

	@Override
	public String nextId(String sequenceName, String prefix) {
		return prefix + nextId(sequenceName);
	}

	@Override
	public long nextId(String sequenceName, int step) {
		return getAtomicLong(sequenceName).addAndGet(step);
	}

	@Override
	public String nextId(String sequenceName, String prefix, int step) {
		return prefix + nextId(sequenceName, step);
	}

	private AtomicLong getAtomicLong(String sequenceName) {
		AtomicLong atomicLong = sequences.get(sequenceName);
		if (atomicLong == null) {
			atomicLong = new AtomicLong(0);
			sequences.put(sequenceName, atomicLong);
		}
		return atomicLong;
	}
}
