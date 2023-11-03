package com.vaibhavtraders.gstapp.requests;

import com.vaibhavtraders.gstapp.dto.CustomerDTO;
import com.vaibhavtraders.gstapp.dto.DeliveryModeDTO;
import com.vaibhavtraders.gstapp.dto.InvoiceDTO;
import com.vaibhavtraders.gstapp.dto.InvoiceItemDTO;

public class InvoiceCreationUpdationRequest {
    private Long invoiceId;
    private InvoiceDTO invoiceDTO;
    private CustomerDTO customerDTO;
    private DeliveryModeDTO deliveryModeDTO;
    private InvoiceItemDTO invoiceItemDTO;

    public Long getInvoiceId() {
        return invoiceId;
    }

    public void setInvoiceId(Long invoiceId) {
        this.invoiceId = invoiceId;
    }

    public InvoiceDTO getInvoiceDTO() {
        return invoiceDTO;
    }

    public void setInvoiceDTO(InvoiceDTO invoiceDTO) {
        this.invoiceDTO = invoiceDTO;
    }

    public CustomerDTO getCustomerDTO() {
        return customerDTO;
    }

    public void setCustomerDTO(CustomerDTO customerDTO) {
        this.customerDTO = customerDTO;
    }

    public DeliveryModeDTO getDeliveryModeDTO() {
        return deliveryModeDTO;
    }

    public void setDeliveryModeDTO(DeliveryModeDTO deliveryModeDTO) {
        this.deliveryModeDTO = deliveryModeDTO;
    }

    public InvoiceItemDTO getInvoiceItemDTO() {
        return invoiceItemDTO;
    }

    public void setInvoiceItemDTO(InvoiceItemDTO invoiceItemDTO) {
        this.invoiceItemDTO = invoiceItemDTO;
    }
}
