package com.example.todo_25;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    DatabaseHelper myDb;
    EditText editName, editSurname, editMarks, editTextId;
    Button btnAddData;
    Button btnViewAll;
    Button btnDelete;
    Button btnViewUpdate;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        myDb = new DatabaseHelper(this);

        editName = findViewById(R.id.firstName);
        editSurname = findViewById(R.id.lastName);
        editMarks = findViewById(R.id.Marks);
        editTextId = findViewById(R.id.ID);
        btnAddData = findViewById(R.id.addData);
        btnViewAll = findViewById(R.id.viewAll);
        btnViewUpdate = findViewById(R.id.update);
        btnDelete = findViewById(R.id.delete);

        //if there is no onClick method, we have to call it here
        AddData();
        viewAll();
        Update();
        Delete();
    }

    public void AddData() {
        btnAddData.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        boolean isInserted = myDb.insertData(editTextId.getText().toString(),
                                editName.getText().toString(),
                                editSurname.getText().toString(),
                                editMarks.getText().toString() );

                        if(isInserted == true)
                            Toast.makeText(MainActivity.this, "Data Inserted", Toast.LENGTH_SHORT).show();
                        else
                            Toast.makeText(MainActivity.this, "Data Not Inserted", Toast.LENGTH_SHORT).show();
                    }
                }
        );
    }

    public void viewAll() {
        btnViewAll.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        //get the data and put it in the cursor because
                        // all the retrieved data will be in the form of cursor
                        Cursor res = myDb.getAllData();
                        if (res.getCount() == 0) {
                            showMessage("Error", "Nothing Found");
                            return;
                        }

                        StringBuffer buffer = new StringBuffer();
                        while (res.moveToNext()) {
                            buffer.append("Student Id : " + res.getString(0) + "\n");
                            buffer.append("First Name : " + res.getString(1) + "\n");
                            buffer.append("Last Name : " + res.getString(2) + "\n");
                            buffer.append("Marks : " + res.getString(3) + "\n");
                        }

                        showMessage("List of Students", buffer.toString());
                    }
                }
        );
    }
    //method for viewall to show message
    public void showMessage(String title, String Message) {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setCancelable(true);
        builder.setTitle(title);
        builder.setMessage(Message);
        builder.show();
    }

    public void Update() {
        btnViewUpdate.setOnClickListener(
                new View.OnClickListener() {

                    @Override
                    public void onClick(View v) {
                        boolean isUpdate = myDb.updateData(editTextId.getText().toString(),
                                editName.getText().toString(),
                                editSurname.getText().toString(),
                                editMarks.getText().toString());

                        if (isUpdate == true )
                            Toast.makeText(MainActivity.this, "Data Updated", Toast.LENGTH_SHORT).show();
                        else
                            Toast.makeText(MainActivity.this, "Data Not Updated", Toast.LENGTH_SHORT).show();
                    }
                });
    }

    public void Delete() {
        btnDelete.setOnClickListener(
                new View.OnClickListener() {

                    @Override
                    public void onClick(View v) {
                        Integer deleteRows = myDb.deleteData(editTextId.getText().toString());
                        if (deleteRows > 0) {
                            Toast.makeText(MainActivity.this, "Data Deleted ", Toast.LENGTH_SHORT).show();
                        }
                        else
                            Toast.makeText(MainActivity.this, "Data not Deleted", Toast.LENGTH_SHORT).show();
                    }
                }
        );
    }
}