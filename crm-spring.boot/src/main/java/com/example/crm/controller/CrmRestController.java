package com.example.crm.controller;

import java.util.List;
import java.util.Map;

import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.annotation.RequestScope;

import com.example.crm.dto.request.AcquireCustomerRequest;
import com.example.crm.dto.request.UpdateCustomerRequest;
import com.example.crm.dto.response.AcquireCustomerResponse;
import com.example.crm.dto.response.CustomerAddressResponse;
import com.example.crm.dto.response.CustomerDTO;
import com.example.crm.dto.response.PatchCustomerResponse;
import com.example.crm.dto.response.ReleaseCustomerResponse;
import com.example.crm.dto.response.UpdateCustomerResponse;
import com.example.crm.service.CustomerService;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.info.Contact;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;

@RestController
@RequestScope
@RequestMapping("/customers")
@CrossOrigin
@Validated
@OpenAPIDefinition(
   info = @Info(title="CRM REST API", contact = @Contact(name="Binnur Kurt",email = "binnur.kurt@gmail.com",url = "https://www.deepcloudlabs.com"))
)
public class CrmRestController {
	private final CustomerService customerService;

	public CrmRestController(CustomerService customerService) {
		this.customerService = customerService;
		System.err.println("CrmRestController(): %s".formatted(customerService.getClass().getName()));
	}

	// "http://localhost:6100/crm/api/v1/customers?page=0&size=10"
	// Query
	@Operation(summary = "Retrieves customer information")
	@ApiResponses({
		@ApiResponse(responseCode = "200", description = "Customer Information")
	})
	@GetMapping(params = { "page", "size" })
	public List<CustomerDTO> getCustomersByPage(@RequestParam(defaultValue = "0") int page,
			@RequestParam(defaultValue = "10") int size) {
		return customerService.findAll(page, size);
	}

	@GetMapping("{identity}")
	public CustomerDTO getCustomerByIdentity(@PathVariable String identity) {
		return customerService.findCustomerByIdentity(identity);
	}
	
	@GetMapping("{identity}/addresses")
	public CustomerAddressResponse getCustomerAddressByIdentity(@PathVariable String identity) {
		return customerService.findCustomerAddressByIdentity(identity);
	}

	// Command
	@PostMapping
	public AcquireCustomerResponse acquireCustomer(@RequestBody AcquireCustomerRequest request) {
		return customerService.acquireCustomer(request);
	}

	@PutMapping("{identity}")
	public UpdateCustomerResponse updateCustomer(@PathVariable String identity,@RequestBody UpdateCustomerRequest request) {
		return customerService.updateCustomer(request);
	}

	@PatchMapping("{identity}")
	public PatchCustomerResponse patchCustomer(@RequestBody Map<String, Object> request) {
		return customerService.patchCustomer(request);
	}

	@DeleteMapping("{identity}")
	public ReleaseCustomerResponse releaseCustomer(@PathVariable String identity) {
		return customerService.releaseCustomer(identity);
	}
}
