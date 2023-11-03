package com.vaibhavtraders.gstapp.response;

import com.vaibhavtraders.gstapp.dto.CountryDTO;
import com.vaibhavtraders.gstapp.dto.CustomerDTO;
import com.vaibhavtraders.gstapp.dto.DeliveryModeDTO;
import com.vaibhavtraders.gstapp.dto.InvoiceDTO;
import com.vaibhavtraders.gstapp.dto.InvoiceItemDTO;
import com.vaibhavtraders.gstapp.dto.ProductDTO;
import com.vaibhavtraders.gstapp.dto.StateDTO;
import com.vaibhavtraders.gstapp.model.Country;
import com.vaibhavtraders.gstapp.model.Customer;
import com.vaibhavtraders.gstapp.model.DeliveryMode;
import com.vaibhavtraders.gstapp.model.Invoice;
import com.vaibhavtraders.gstapp.model.InvoiceItem;
import com.vaibhavtraders.gstapp.model.Product;
import com.vaibhavtraders.gstapp.model.State;

import java.util.List;

public class ResponseObject {
    String successMessage;
    String failureMessage;

    Country country;
    CountryDTO countryDTO;
    private List<CountryDTO> countryDTOList;

    Customer customer;
    CustomerDTO customerDTO;
    private List<CustomerDTO> customerDTOList;

    DeliveryMode deliveryMode;
    DeliveryModeDTO deliveryModeDTO;
    private List<DeliveryModeDTO> deliveryModeDTOList;

    Invoice invoice;
    InvoiceDTO invoiceDTO;
    private List<InvoiceDTO> invoiceDTOList;

    InvoiceItem invoiceItem;
    InvoiceItemDTO invoiceItemDTO;
    private List<InvoiceItemDTO> invoiceItemDTOList;

    Product product;
    ProductDTO productDTO;
    private List<ProductDTO> productDTOList;

    State state;
    StateDTO stateDTO;
    private List<StateDTO> stateDTOList;
    public String getSuccessMessage() {
        return successMessage;
    }
    public void setSuccessMessage(String successMessage) {
        this.successMessage = successMessage;
    }
    public String getFailureMessage() {
        return failureMessage;
    }
    public void setFailureMessage(String failureMessage) {
        this.failureMessage = failureMessage;
    }
    public Country getCountry() {
        return country;
    }
    public void setCountry(Country country) {
        this.country = country;
    }
    public CountryDTO getCountryDTO() {
        return countryDTO;
    }
    public void setCountryDTO(CountryDTO countryDTO) {
        this.countryDTO = countryDTO;
    }
    public List<CountryDTO> getCountryDTOList() {
        return countryDTOList;
    }
    public void setCountryDTOList(List<CountryDTO> countryDTOList) {
        this.countryDTOList = countryDTOList;
    }
    public Customer getCustomer() {
        return customer;
    }
    public void setCustomer(Customer customer) {
        this.customer = customer;
    }
    public CustomerDTO getCustomerDTO() {
        return customerDTO;
    }
    public void setCustomerDTO(CustomerDTO customerDTO) {
        this.customerDTO = customerDTO;
    }
    public List<CustomerDTO> getCustomerDTOList() {
        return customerDTOList;
    }
    public void setCustomerDTOList(List<CustomerDTO> customerDTOList) {
        this.customerDTOList = customerDTOList;
    }
    public DeliveryMode getDeliveryMode() {
        return deliveryMode;
    }
    public void setDeliveryMode(DeliveryMode deliveryMode) {
        this.deliveryMode = deliveryMode;
    }
    public DeliveryModeDTO getDeliveryModeDTO() {
        return deliveryModeDTO;
    }
    public void setDeliveryModeDTO(DeliveryModeDTO deliveryModeDTO) {
        this.deliveryModeDTO = deliveryModeDTO;
    }
    public List<DeliveryModeDTO> getDeliveryModeDTOList() {
        return deliveryModeDTOList;
    }
    public void setDeliveryModeDTOList(List<DeliveryModeDTO> deliveryModeDTOList) {
        this.deliveryModeDTOList = deliveryModeDTOList;
    }
    public Invoice getInvoice() {
        return invoice;
    }
    public void setInvoice(Invoice invoice) {
        this.invoice = invoice;
    }
    public InvoiceDTO getInvoiceDTO() {
        return invoiceDTO;
    }
    public void setInvoiceDTO(InvoiceDTO invoiceDTO) {
        this.invoiceDTO = invoiceDTO;
    }
    public List<InvoiceDTO> getInvoiceDTOList() {
        return invoiceDTOList;
    }
    public void setInvoiceDTOList(List<InvoiceDTO> invoiceDTOList) {
        this.invoiceDTOList = invoiceDTOList;
    }
    public InvoiceItem getInvoiceItem() {
        return invoiceItem;
    }
    public void setInvoiceItem(InvoiceItem invoiceItem) {
        this.invoiceItem = invoiceItem;
    }
    public InvoiceItemDTO getInvoiceItemDTO() {
        return invoiceItemDTO;
    }
    public void setInvoiceItemDTO(InvoiceItemDTO invoiceItemDTO) {
        this.invoiceItemDTO = invoiceItemDTO;
    }
    public List<InvoiceItemDTO> getInvoiceItemDTOList() {
        return invoiceItemDTOList;
    }
    public void setInvoiceItemDTOList(List<InvoiceItemDTO> invoiceItemDTOList) {
        this.invoiceItemDTOList = invoiceItemDTOList;
    }
    public Product getProduct() {
        return product;
    }
    public void setProduct(Product product) {
        this.product = product;
    }
    public ProductDTO getProductDTO() {
        return productDTO;
    }
    public void setProductDTO(ProductDTO productDTO) {
        this.productDTO = productDTO;
    }
    public List<ProductDTO> getProductDTOList() {
        return productDTOList;
    }
    public void setProductDTOList(List<ProductDTO> productDTOList) {
        this.productDTOList = productDTOList;
    }
    public State getState() {
        return state;
    }
    public void setState(State state) {
        this.state = state;
    }
    public StateDTO getStateDTO() {
        return stateDTO;
    }
    public void setStateDTO(StateDTO stateDTO) {
        this.stateDTO = stateDTO;
    }
    public List<StateDTO> getStateDTOList() {
        return stateDTOList;
    }
    public void setStateDTOList(List<StateDTO> stateDTOList) {
        this.stateDTOList = stateDTOList;
    }
}
