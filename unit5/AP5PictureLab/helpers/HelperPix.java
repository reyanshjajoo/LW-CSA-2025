package helpers;

import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.fail;

import java.awt.Color;
import java.security.MessageDigest;
import java.util.Arrays;
import java.util.Base64;

public class HelperPix {

    // #region: Private methods
    private static String toMD5(String input) {
        try {
            MessageDigest md = MessageDigest.getInstance("MD5");
            byte[] messageDigest = md.digest(input.getBytes());
            
            StringBuilder sb = new StringBuilder();
            for (byte b : messageDigest) {
                sb.append(String.format("%02x", b));
            }
            return sb.toString();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    private static Color toColor(String input) {
        Color col = Color.black;
        try {
            String[] parts = input.split(",");
            int[] rgb = Arrays.stream(parts).mapToInt(Integer::parseInt).toArray();
            col = new Color(rgb[0], rgb[1], rgb[2]);
        } catch (Exception e) {
            fail("\n\nInvalid format in answer. Expected comma-separated numbers (i.e. \"1,2,3\")\n\n");
        }
        return col;
    }
    
    public static double colorDistance(Color c1, Color c2) {
        int dr = c1.getRed() - c2.getRed();
        int dg = c1.getGreen() - c2.getGreen();
        int db = c1.getBlue() - c2.getBlue();
        return Math.sqrt(dr * dr + dg * dg + db * db);
    }
    // #endregion: Private methods

    // #region: validation helpers
    public static void checkAnswer(String expected, String actual) {
        String encodedAnswer = toMD5(actual.toLowerCase());
        assertTrue(encodedAnswer.contains(expected), String.format("\n\n'%s' is incorrect!\n\n", actual));
    }

    public static void checkColor(String expected, String actual) {
        String decoded = new String(Base64.getDecoder().decode(expected));
        Color expectedCol = toColor(decoded);
        Color actualCol = toColor(actual);
        double colDistance = colorDistance(expectedCol, actualCol);
        assertTrue(colDistance < 50, String.format("\n\nColor \"%s\" too far from \"%s\" (%f &gt; 50.0)\n\n", actual, decoded, colDistance));
    }
    // #endregion: validation helpers
}
