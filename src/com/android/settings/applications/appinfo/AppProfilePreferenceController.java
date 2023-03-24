/*
 * Copyright (C) 2017 The Android Open Source Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.android.settings.applications.appinfo;

import static android.Manifest.permission.SYSTEM_ALERT_WINDOW;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.os.UserManager;

import androidx.preference.PreferenceScreen;

import com.android.settings.SettingsPreferenceFragment;
import com.crdroid.settings.fragments.AppProfileFragment;

import com.android.settingslib.applications.AppUtils;

public class AppProfilePreferenceController extends AppInfoPreferenceControllerBase {

    public AppProfilePreferenceController(Context context, String key) {
        super(context, key);
    }

    @Override
    public int getAvailabilityStatus() {
        return AVAILABLE;
    }

    @Override
    public void displayPreference(PreferenceScreen screen) {
        super.displayPreference(screen);
        mPreference.setEnabled(AppUtils.isAppInstalled(mAppEntry));
    }

    @Override
    protected Class<? extends SettingsPreferenceFragment> getDetailFragmentClass() {
        return AppProfileFragment.class;
    }

    @Override
    public CharSequence getSummary() {
        return null; // DrawOverlayDetails.getSummary(mContext, mParent.getAppEntry());
    }
}
