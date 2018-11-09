package com.droidmentor.mlkitbarcodescan.Util;

/**
 * Created by Jaison.
 */
public class BarcodeScanner
{
    public static class Constants
    {
        public static final int PERMISSION_REQUEST_CAMERA = 1001;

        public static final int FACING_BACK = 0;
        public static final int FACING_FRONT = 1;

        public static final int FLASH_OFF = 0;
        public static final int FLASH_ON = 1;
        public static final int FLASH_AUTO = 2;
        public static final int FLASH_TORCH = 3;

        public static final int FOCUS_OFF = 0;
        public static final int FOCUS_CONTINUOUS = 1;
        public static final int FOCUS_TAP = 2;
        public static final int FOCUS_TAP_WITH_MARKER = 3;

        public static final String KEY_CAMERA_PERMISSION_GRANTED="CAMERA_PERMISSION_GRANTED";

    }

    static class Defaults {
        static final int DEFAULT_FACING = Constants.FACING_BACK;
        static final int DEFAULT_FLASH = Constants.FLASH_OFF;
        static final int DEFAULT_FOCUS = Constants.FOCUS_CONTINUOUS;
    }

    public static class MessageStrings
    {
        public static final String ERROR_LOW_STORAGE="QR Scanner dependencies cannot be downloaded due to low device storage";
    }
}
