package com.astontech.hr.domain.VO;

public class ContactVO {
    private String contactId;
    private String contactVersion;
    private String addressId;
    private String contactName;
    private String createDate;
    private String addressName;
    private String street;
    private String street2;
    private String state;
    private String city;

    public ContactVO() {};

    public String getContactName() {
        return contactName;
    }

    public String getContactId() {
        return contactId;
    }

    public void setContactId(String id) {
        this.contactId = id;
    }

    public String getContactVersion() {
        return contactVersion;
    }

    public String getAddressId() {
        return addressId;
    }

    public void setAddressId(String addressId) {
        this.addressId = addressId;
    }

    public void setContactVersion(String version) {
        this.contactVersion = version;
    }

    public void setContactName(String contactName) {
        this.contactName = contactName;
    }

    public String getCreateDate() {
        return createDate;
    }

    public void setCreateDate(String createDate) {
        this.createDate = createDate;
    }

    public String getAddressName() {
        return addressName;
    }

    public void setAddressName(String addressName) {
        this.addressName = addressName;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getStreet2() {
        return street2;
    }

    public void setStreet2(String street2) {
        this.street2 = street2;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }
}
