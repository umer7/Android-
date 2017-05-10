package com.example.umer.umer21;

import android.support.v7.app.AppCompatActivity;

        //import android.support.v7.app.ActionBarActivity;
        import android.os.Bundle;
        import android.view.View;
        import android.widget.EditText;
        import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    EditText umerInput;
    TextView umerText;
    mydbhandler dbHandler;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        umerInput = (EditText) findViewById(R.id.umerinput);
        umerText = (TextView) findViewById(R.id.umertext);
        dbHandler = new mydbhandler(this, null, null, 1);
        printDatabase();
    }

    //Add a product to the database
    public void addButtonClicked(View view) {
        products product = new products(umerInput.getText().toString());
        dbHandler.addproduct(product);
        printDatabase();
    }

    //Delete items
    public void deleteButtonClicked(View view) {
        String inputText = umerInput.getText().toString();
        dbHandler.deleteproduct(inputText);
        printDatabase();
    }

    //Print the database
    public void printDatabase() {
        String dbString = dbHandler.databaseTOString();
        //String dbString = dbHandler.databaseToString();
        umerText.setText(dbString);
        umerInput.setText("");
    }
}

