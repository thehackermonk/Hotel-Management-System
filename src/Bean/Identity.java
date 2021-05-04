/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Bean;

/**
 *
 * @author thehackermonk
 */
public class Identity extends Guest {

    private long adhaar_no;
    private int yearOfBirth;

    public long getAdhaar_no() {
        return adhaar_no;
    }

    public void setAdhaar_no(long adhaar_no) {
        this.adhaar_no = adhaar_no;
    }

    public int getYearOfBirth() {
        return yearOfBirth;
    }

    public void setYearOfBirth(int yearOfBirth) {
        this.yearOfBirth = yearOfBirth;
    }

}
