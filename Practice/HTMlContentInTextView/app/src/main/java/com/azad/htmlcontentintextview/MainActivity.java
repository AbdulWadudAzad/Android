package com.azad.htmlcontentintextview;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.Html;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private TextView textView;
    String myText = "<h1> This is heading 1 </h1> \n" +
            "<h2> This is heading 2 </h2> \n" +
            "<h4> This is heading 4 </h4> \n" +
            "<p> This is Paragraph </p> \n" +
            "<p><u> This is Paragraph with Underline </u> </p> \n" +
            "<p><i> This is Italic Paragraph </i> </p> \n" +
            "Programming language list\n" +
            "<ol>\n" +
            "<li>java</li>\n" +
            "<li>c++</li>\n" +
            "<li>c</li>\n" +
            "</ol>\n\n" +
            "(a+b)<sup>2</sup> = a<sup>2</sup>+2ab+b<sup>2</sup>";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textView = (TextView) findViewById(R.id.textViewId);
        textView.setText(Html.fromHtml(myText));

    }
}
