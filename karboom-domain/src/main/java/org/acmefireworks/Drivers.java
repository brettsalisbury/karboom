package org.acmefireworks;

/**
 * Created by IntelliJ IDEA.
 * User: Brett
 * Date: 9/04/12
 * Time: 2:21 PM
 * To change this template use File | Settings | File Templates.
 */
public class Drivers {

    private String[] drivers;

    public Drivers() {
        drivers = new String[]{};
    }

    public String[] getCurrentDrivers() {
        return this.drivers;
    }

    public void setCurrentDrivers(String[] drivers) {
        this.drivers = drivers;
    }

}
