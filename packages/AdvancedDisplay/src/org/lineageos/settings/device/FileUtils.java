/*
 * SPDX-License-Identifier: Apache-2.0
 * Minimal sysfs helpers so AdvancedDisplay builds without lineage-sdk.
 */
package org.lineageos.settings.device;

import android.util.Log;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public final class FileUtils {
    private static final String TAG = "AdvancedDisplay-FileUtils";

    private FileUtils() {}

    public static String readOneLine(String fileName) {
        try (BufferedReader reader = new BufferedReader(new FileReader(fileName), 512)) {
            return reader.readLine();
        } catch (FileNotFoundException e) {
            Log.w(TAG, "No such file " + fileName + " for reading", e);
        } catch (IOException e) {
            Log.e(TAG, "Could not read from file " + fileName, e);
        }
        return null;
    }

    public static boolean writeLine(String fileName, String value) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(fileName))) {
            writer.write(value);
            return true;
        } catch (FileNotFoundException e) {
            Log.w(TAG, "No such file " + fileName + " for writing", e);
        } catch (IOException e) {
            Log.e(TAG, "Could not write to file " + fileName, e);
        }
        return false;
    }

    public static boolean fileExists(String fileName) {
        return new File(fileName).exists();
    }

    public static boolean isFileReadable(String fileName) {
        File f = new File(fileName);
        return f.exists() && f.canRead();
    }

    public static boolean isFileWritable(String fileName) {
        File f = new File(fileName);
        return f.exists() && f.canWrite();
    }
}
