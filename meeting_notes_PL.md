Going beyond onCreate/onStart/onResume -> onPause/onStop/onDestroy

Application lifecycle
- when is onCreate called?
-- Called when the application is starting, before any activity, service, or receiver objects (excluding content providers) have been created. https://developer.android.com/reference/android/app/Application#onCreate()
-- adb shell am broadcast -a lifecycle.TEST -n com.github.zawadz88.androidlifecycle/.MyReceiver
-- to moga byc PUSHe np.
Logcat filter: MyApplication


when is onPause(), onStop(), onDestroy(), onSaveInstance(), onRestart() called jak odpalamy dialog, dialog fragment, activity, activity translucent
-- default
-- translucent
-- open dialog
-- open dialog fragment
-- show rotation for dialogs
-- replace fragment
Logcat filter: Activity|Fragment


Fragment userVisibleHint + nowa metoda
-- ViewPager legacy sample
-- viewPager new sample
-- ViewPager2 sample
Logcat filter: Fragment


co się stanie jak będę zawsze robił replaceFragment bez checka na `savedInstanceState`
Logcat filter: Fragment


Kolejnosc lifecycle Activity/Fragment default vs recreate on rotation


ViewModel lifecycle
- tutaj bedzie live coding
- how to load data on start?
- how to persist the data in a ViewModel on process death
- jak zasymulowac process death - https://codelabs.developers.google.com/codelabs/android-lifecycles/#6
- limits on data persistance


własny LifecycleObserver -> po co i jak?
Sample class - MyLifecycleAwareComponent


ProcessLifecycleOwner
sample class - ApplicationForegroundObserver


onResume/onPause in multi-window, changes in Android 10/Q/API 29
Logcat filter: Activity



kiedy sie onStart/onResume nie wywoła -> finish() w onCreate
Logcat filter: Activity


LiveData -> kiedy wpadnie mi nowa wartość -> powroty z poprzedniego ekranu?
