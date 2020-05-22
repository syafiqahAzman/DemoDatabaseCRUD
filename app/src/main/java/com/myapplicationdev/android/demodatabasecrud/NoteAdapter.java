package com.myapplicationdev.android.demodatabasecrud;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.ArrayList;

public class NoteAdapter extends ArrayAdapter<Note> {

    private ArrayList<Note> note;
    private Context context;
    private TextView tvLv;

    public NoteAdapter(Context context, int resource, ArrayList<Note> objects){
        super(context, resource,objects);

        //Store the note that is passed to this adapter
        note = objects;

        //Store context object as we would need it later
        this.context = context;
    }

    //This method is called to get the view
    public View getView(int position, View convertView, ViewGroup parent){

        //To inflate the XML file into view object
        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);

        //Inflate the row.xml as the layout for the view object
        View rowView = inflater.inflate(R.layout.row, parent, false);

        //Get the object
        tvLv = rowView.findViewById(R.id.tvLv);

        //The "position" is the index of the row that the listview is requesting
        //We get back the note at the same index
        Note currentNote = note.get(position);

        //Set the textview to show the notes
        tvLv.setText(currentNote.getNoteContent());

        return rowView;
    }
}
