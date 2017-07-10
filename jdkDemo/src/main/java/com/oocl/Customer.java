package com.oocl;

/**
 * Created by CHENCO7 on 7/10/2017.
 */
public class Customer implements Cloneable, Comparable<Customer>{
    public int id;
    public int age;
    public String name;
    public Address address;

//    @Override
//    public boolean equals(Object obj) {
//        if(obj == null){
//            return false;
//        }
//        if(!(obj instanceof Customer)){
//            return false;
//        }
//        Customer customer = (Customer)obj;
//        return this.id == customer.id;
//    }


//    @Override
//    public Object clone() throws CloneNotSupportedException {
//        return super.clone();
//    }


    //by me
//    @Override
//    public Object clone() {
//        Customer o = null;
//        try {
//            o = (Customer)super.clone();
//        } catch (CloneNotSupportedException e) {
//            e.printStackTrace();
//        }
//
//        o.address = (Address)address.clone();
//        return o;
//    }

    //by teacher
    @Override
    public Object clone() {
        Object o = null;
        try {
            o = super.clone();
            Customer c = (Customer) o;
            c.address = (Address)this.address.clone();
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }
        return o;
    }

//    @Override
//    public boolean equals(Object o) {
//        if (this == o) return true;
//        if (o == null || getClass() != o.getClass()) return false;
//
//        Customer customer = (Customer) o;
//
//        if (id != customer.id) return false;
//        return age == customer.age;
//
//    }
//
//    @Override
//    public int hashCode() {
//        int result = id;
//        result = 31 * result + age;
//        return result;
//    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Customer customer = (Customer) o;

        return age == customer.age;

    }

    @Override
    public int hashCode() {
        return age;
    }

    public int compareTo(Customer o) {
        return this.id - o.id;
    }

    @Override
    public String toString() {
        return "Customer{" +
                "id=" + id +
                ", age=" + age +
                ", name='" + name + '\'' +
                ", address=" + address +
                '}';
    }
}
