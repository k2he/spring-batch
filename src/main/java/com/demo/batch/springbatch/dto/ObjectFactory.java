//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.8-b130911.1802 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2020.06.21 at 09:14:18 PM EDT 
//


package com.demo.batch.springbatch.dto;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.datatype.XMLGregorianCalendar;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the com.demo.batch.springbatch.dto package. 
 * <p>An ObjectFactory allows you to programatically 
 * construct new instances of the Java representation 
 * for XML content. The Java representation of XML 
 * content can consist of schema derived interfaces 
 * and classes representing the binding of schema 
 * type definitions, element declarations and model 
 * groups.  Factory methods for each of these are 
 * provided in this class.
 * 
 */
@XmlRegistry
public class ObjectFactory {

    private final static QName _OrderListOrderNote_QNAME = new QName("", "note");
    private final static QName _OrderListOrderAmount_QNAME = new QName("", "amount");
    private final static QName _OrderListOrderOrderRef_QNAME = new QName("", "orderRef");
    private final static QName _OrderListOrderOrderDate_QNAME = new QName("", "orderDate");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: com.demo.batch.springbatch.dto
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link OrderList }
     * 
     */
    public OrderList createOrderList() {
        return new OrderList();
    }

    /**
     * Create an instance of {@link OrderList.Order }
     * 
     */
    public OrderList.Order createOrderListOrder() {
        return new OrderList.Order();
    }

    /**
     * Create an instance of {@link OrderList.Order.ProductInformation }
     * 
     */
    public OrderList.Order.ProductInformation createOrderListOrderProductInformation() {
        return new OrderList.Order.ProductInformation();
    }

    /**
     * Create an instance of {@link OrderList.Order.ProductInformation.ProductOfferList }
     * 
     */
    public OrderList.Order.ProductInformation.ProductOfferList createOrderListOrderProductInformationProductOfferList() {
        return new OrderList.Order.ProductInformation.ProductOfferList();
    }

    /**
     * Create an instance of {@link OrderList.Order.ProductInformation.ProductOfferList.ProductOffer }
     * 
     */
    public OrderList.Order.ProductInformation.ProductOfferList.ProductOffer createOrderListOrderProductInformationProductOfferListProductOffer() {
        return new OrderList.Order.ProductInformation.ProductOfferList.ProductOffer();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "", name = "note", scope = OrderList.Order.class)
    public JAXBElement<String> createOrderListOrderNote(String value) {
        return new JAXBElement<String>(_OrderListOrderNote_QNAME, String.class, OrderList.Order.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Float }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "", name = "amount", scope = OrderList.Order.class)
    public JAXBElement<Float> createOrderListOrderAmount(Float value) {
        return new JAXBElement<Float>(_OrderListOrderAmount_QNAME, Float.class, OrderList.Order.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "", name = "orderRef", scope = OrderList.Order.class)
    public JAXBElement<String> createOrderListOrderOrderRef(String value) {
        return new JAXBElement<String>(_OrderListOrderOrderRef_QNAME, String.class, OrderList.Order.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link XMLGregorianCalendar }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "", name = "orderDate", scope = OrderList.Order.class)
    public JAXBElement<XMLGregorianCalendar> createOrderListOrderOrderDate(XMLGregorianCalendar value) {
        return new JAXBElement<XMLGregorianCalendar>(_OrderListOrderOrderDate_QNAME, XMLGregorianCalendar.class, OrderList.Order.class, value);
    }

}
