/*
 * SPDX-License-Identifier: Apache-2.0
 * Replacement for org.lineageos.internal.util.ScreenType (no lineage-sdk).
 */
package org.lineageos.settings.doze;

import android.content.Context;

public final class ScreenType {
    private ScreenType() {}

    private static int smallestWidthDp(Context context) {
        return context.getResources().getConfiguration().smallestScreenWidthDp;
    }

    public static boolean isPhone(Context context) {
        return smallestWidthDp(context) < 600;
    }

    public static boolean isHybrid(Context context) {
        int sw = smallestWidthDp(context);
        return sw >= 600 && sw < 720;
    }

    public static boolean isTablet(Context context) {
        return smallestWidthDp(context) >= 720;
    }
}
