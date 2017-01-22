//package pgdp;

/**
 * Created by fga on 17/01/2017.
 */
public class Password {

    private final int nrUpperShould;

    private final int nrLowerShould;

    private final int nrSpecialShould;

    private final int nrNumbersShould;

    private final int lengthShould;

    private final char[] illegalChars;

    Password(int nrUpperShould, int nrLowerShould, int nrSpecialShould, int nrNumbersShould, int lengthShould, char[] illegalChars)  {
        this.nrUpperShould = nrUpperShould;
        this.nrLowerShould = nrLowerShould;
        this.nrSpecialShould = nrSpecialShould;
        this.nrNumbersShould = nrNumbersShould;
        this.lengthShould = lengthShould;
        this.illegalChars = illegalChars;
    }

    public void checkFormat(String pwd) throws IllegalCharExc, NotEnoughExc, NotLongEnoughExc {
        int upper = 0, lower = 0, special = 0, numbers = 0;

        // check length
        int length = pwd.length();
        if (length < lengthShould) {
            throw new NotLongEnoughExc(lengthShould, length);
        }

        // loop through string
        for (int i = 0; i < length; i++) {
            char c = pwd.charAt(i);
            int ascii = (int)c;

            if (ascii >= 65 && ascii <= 90) {
                upper++;
            } else if (ascii >= 97 && ascii <= 122) {
                lower++;
            } else if ((ascii >= 33 && ascii <= 47) || (ascii >= 58 && ascii <= 64) || (ascii >= 91 && ascii <= 96) || (ascii >= 123 && ascii <= 126)) {
                special++;
            } else if (ascii >= 48 && ascii <= 57) {
                numbers++;
            }

            // check for illegal chars
            for (int j = 0; j < illegalChars.length; j++) {
                if (c == illegalChars[j]) {
                    throw new IllegalCharExc(c);
                }
            }
        }

        // check all values
        if (upper < nrUpperShould) {
            throw new NotEnoughUpper(nrUpperShould, upper);
        }

        if (lower < nrLowerShould) {
            throw new NotEnoughLower(nrLowerShould, lower);
        }

        if (special < nrSpecialShould) {
            throw new NotEnoughSpecial(nrSpecialShould, special);
        }

        if (numbers < nrNumbersShould) {
            throw new NotEnoughNumber(nrNumbersShould, numbers);
        }
    }

    public static void main(String[] args) {
        Password password = new Password(1, 1, 1, 1, 8, new char[]{' '});

        try {
            password.checkFormat("asdfASDF1234+#,- ");
        } catch (IllegalCharExc e) {
            System.out.println(e.toString());
        } catch (NotLongEnoughExc e) {
            System.out.println(e.toString());
        } catch (NotEnoughExc e) {
            System.out.println(e.toString());
        }
    }

}
