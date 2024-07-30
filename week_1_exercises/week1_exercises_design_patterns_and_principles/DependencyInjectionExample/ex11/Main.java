package ex11;

public class Main {
	public static void main(String[] args) {
        CustomerRepository customerRepository = new CustomerRepositoryImpl();
        CustomerService customerService = new CustomerService(customerRepository);

        Customer customer = customerService.getCustomerById(3);
        
        if (customer != null) {
            System.out.println("Customer Found: " + customer.getName());
        } else {
            System.out.println("Customer not found.");
        }
    }
}
