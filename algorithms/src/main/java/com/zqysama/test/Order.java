package com.zqysama.test;

public class Order {

    private String orderNo;

    private String amount;

    public Order(String orderNo, String amount) {
        this.orderNo = orderNo;
        this.amount = amount;
    }

    public String getOrderNo() {
        return orderNo;
    }

    public void setOrderNo(String orderNo) {
        this.orderNo = orderNo;
    }

    public String getAmount() {
        return amount;
    }

    public void setAmount(String amount) {
        this.amount = amount;
    }

    @Override
    public String toString() {
        return "Order{" +
                "orderNo='" + orderNo + '\'' +
                ", amount='" + amount + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object obj) {
        if(this == obj){
            return true;//地址相等
        }

        if(obj == null){
            return false;//非空性：对于任意非空引用x，x.equals(null)应该返回false。
        }

        if(obj instanceof Order){
            Order other = (Order) obj;
            //需要比较的字段相等，则这两个对象相等
            if(equalsStr(this.orderNo, other.orderNo)
                    && equalsStr(this.amount, other.amount)){
                return true;
            }
        }

        return false;
    }

    private boolean equalsStr(String str1, String str2){
        if(str1.equals(str2)){
            return true;
        }
        return false;
    }

    @Override
    public int hashCode() {
        int result = 17;
        result = 31 * result + (orderNo == null ? 0 : orderNo.hashCode());
        result = 31 * result + (amount == null ? 0 : amount.hashCode());
        return result;
    }
}
