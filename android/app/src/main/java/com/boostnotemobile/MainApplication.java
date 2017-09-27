package com.boostnotemobile;

import android.app.Application;

import com.RNFetchBlob.RNFetchBlobPackage;
import com.facebook.react.ReactApplication;
import com.facebook.react.ReactNativeHost;
import com.facebook.react.ReactPackage;
import com.facebook.react.shell.MainReactPackage;
import com.facebook.soloader.SoLoader;
import com.microsoft.codepush.react.CodePush;
import com.taplytics.react.TaplyticsReactPackage;
import com.taplytics.sdk.Taplytics;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class MainApplication extends Application implements ReactApplication {

  private final ReactNativeHost mReactNativeHost = new ReactNativeHost(this) {

    @Override
    protected String getJSBundleFile() {
      return CodePush.getJSBundleFile();
    }

    @Override
    public boolean getUseDeveloperSupport() {
      return BuildConfig.DEBUG;
    }

    @Override
    protected List<ReactPackage> getPackages() {
      return Arrays.<ReactPackage>asList(
          new MainReactPackage(),
          new RNFetchBlobPackage(),
          new TaplyticsReactPackage(),
          new CodePush("byLfL38UaCCfKxo_2kTLHuR190e81a2d16b3-a6fd-494f-8deb-050bb34a68be", MainApplication.this, BuildConfig.DEBUG)
      );
    }
  };

  @Override
  public ReactNativeHost getReactNativeHost() {
    return mReactNativeHost;
  }

  @Override
  public void onCreate() {
    super.onCreate();
    SoLoader.init(this, /* native exopackage */ false);
    HashMap<String, Object> options = new HashMap<>();
    options.put("debugLogging", true);
    options.put("liveUpdate", true);
    Taplytics.startTaplytics(this, "0e9e98120f1334dc5754cd3247ea8df0127a81e8", options);
  }
}
