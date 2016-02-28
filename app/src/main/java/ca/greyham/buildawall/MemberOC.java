package ca.greyham.buildawall;

/**
 * Created by Graham on 2016-02-27.
 */
public class MemberOC {


    private String pressRelease;
    private Integer billsPassed;
    private Integer billsVetoed;
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPressRelease() {
        return pressRelease;
    }

    public void setPressRelease(String pressRelease) {
        this.pressRelease = pressRelease;
    }

    public Integer getBillsPassed() {
        return billsPassed;
    }

    public void setBillsPassed(int billsPassed) {
        this.billsPassed = billsPassed;
    }

    public Integer getBillsVetoed() {
        return billsVetoed;
    }

    public void setBillsVetoed(int billsVetoed) {
        this.billsVetoed = billsVetoed;
    }
}
