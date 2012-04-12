package com.acme.karboom.webapp.formobjects;

/**
 * Created by IntelliJ IDEA.
 * User: Brett
 * Date: 9/04/12
 * Time: 2:21 PM
 * To change this template use File | Settings | File Templates.
 */
public class NewDrivers {

    private String[] drivers;

    public NewDrivers() {
        drivers = new String[]{};
    }

    public String[] getDrivers() {
        return this.drivers;
    }

    public void setDrivers(String[] drivers) {
        this.drivers = drivers;
    }

}
