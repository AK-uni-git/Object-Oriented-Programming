package com.week10;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.KeyEvent;
import android.view.View;
import android.view.inputmethod.EditorInfo;
import android.webkit.WebResourceError;
import android.webkit.WebResourceRequest;
import android.webkit.WebResourceResponse;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.ListIterator;


public class MainActivity<Snackbar> extends AppCompatActivity {
    private String index = "file:///android_asset/index.html";

    private WebView web;
    private EditText urlInput;
    private Context context;
    private String urlForClearingHistory = null;
    private String currentUrl = "";
    private boolean backHasNotBeenPressed = true;
    private boolean refreshHasNotBeenPressed = true;
    ArrayList<String> urlHistory = new ArrayList<>();
    ListIterator urlIterator = urlHistory.listIterator();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        context = getApplicationContext();

        urlInput = findViewById(R.id.urlInput);
        web = findViewById(R.id.webView);
        web.setWebViewClient(new WebViewClient() {
            @Override
            public void onPageCommitVisible(WebView view, String url) {
                System.out.println("URL!");
                System.out.println(url);
                if (url.equals(index)) {
                    urlInput.setText("index.html");
                } else {
                    urlInput.setText(url);
                }

                currentUrl = url;

                if (backHasNotBeenPressed && refreshHasNotBeenPressed) {
                    System.out.println("URL WAS ADDED TO LIST");
                    System.out.println(url);
                    urlHistory.add(url);
                }
                if (!refreshHasNotBeenPressed) {
                    refreshHasNotBeenPressed = true;
                }
            }

            // Source: https://stackoverflow.com/questions/4997677/android-webview-onreceivederror

            @Override
            public void onReceivedError(WebView view, int errorCode, String description, String failingUrl) {
                popUpError(failingUrl);
            }
        });
        web.getSettings().setJavaScriptEnabled(true);
        web.loadUrl(index);

        // Source: https://stackoverflow.com/questions/8063439/android-edittext-finished-typing-event
        urlInput.setOnEditorActionListener(
                new EditText.OnEditorActionListener() {
                    @Override
                    public boolean onEditorAction(TextView v, int actionId, KeyEvent event) {
                        if (actionId == EditorInfo.IME_ACTION_SEARCH ||
                                actionId == EditorInfo.IME_ACTION_DONE ||
                                event != null &&
                                        event.getAction() == KeyEvent.ACTION_DOWN &&
                                        event.getKeyCode() == KeyEvent.KEYCODE_ENTER) {
                            if (event == null || !event.isShiftPressed()) {
                                System.out.println("URL WAS WRITTEN");
                                System.out.println(urlInput.getText().toString());
                                changeUrlUserInput(urlInput.getText().toString());

                                return true; // consume.
                            }
                        }
                        return false; // pass on to other listeners.
                    }
                }
        );
    }

    private void popUpError(String url) {
        Toast toast = Toast.makeText(context, "Page '" + url + "' could not be loaded", Toast.LENGTH_SHORT);
        toast.show();
    }


    public void executeShoutOut(View v) {
        web.evaluateJavascript("javascript:shoutOut()", null);
    }

    public void executeinitialize(View v) {
        web.evaluateJavascript("javascript:initialize()", null);
    }

    public void refreshPage(View v) {
        web.reload();
        refreshHasNotBeenPressed = false;
    }

    public void goBack(View v) {
        if(backHasNotBeenPressed) {
            urlIterator = urlHistory.listIterator(urlHistory.size());
        }
        backHasNotBeenPressed = false;
        if (urlIterator.hasPrevious()) {
            String previous = (String) urlIterator.previous();
            if (previous.equals(currentUrl) && urlIterator.hasPrevious()) {
                previous = (String) urlIterator.previous();
            }
            System.out.println("PREVIOUS");
            System.out.println(previous);
            urlForClearingHistory = previous;
            changeUrlHistory(previous);
        } else {
            Toast.makeText(context, "Cannot go further back.", Toast.LENGTH_SHORT).show();
        }
    }

    public void goForward(View v) {
        if (urlIterator.hasNext()) {
            String next = (String) urlIterator.next();
            if (next.equals(currentUrl) && urlIterator.hasNext()) {
                next = (String) urlIterator.next();
            }
            System.out.println("NEXT");
            System.out.println(next);
            urlForClearingHistory = next;
            changeUrlHistory(next);
        } else {
            Toast.makeText(context, "Cannot go further forward.", Toast.LENGTH_SHORT).show();
        }
    }

    public void changeUrlHistory(String url) {
        if (url.equals(index)) {
            web.loadUrl(index);
        } else {
            web.loadUrl(url);
        }

    }

    public void changeUrlUserInput(String url) {
        if (!backHasNotBeenPressed) {
            int index = urlHistory.indexOf(urlForClearingHistory);
            System.out.println(index);
            // Clearing list after specific index  https://stackoverflow.com/questions/22802232/remove-all-elements-from-a-list-after-a-particular-index
            urlHistory.subList(index +1, urlHistory.size()).clear();
        }
        backHasNotBeenPressed = true;
        if (url.equals("index.html")) {
            web.loadUrl(index);
        } else {
            if (url.contains("http://")) {
                web.loadUrl(url);
            } else {
                web.loadUrl("http://" + url);
            }

        }

    }
}
