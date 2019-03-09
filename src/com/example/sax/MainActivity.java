package com.example.sax;

import java.io.InputStream;
import java.util.ArrayList;
 
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
 
import org.xml.sax.InputSource;
import org.xml.sax.XMLReader;
 
import android.app.Activity;
import android.content.res.AssetManager;
import android.os.Bundle;
import android.widget.TextView;

import com.example.sax.R;
 
public class MainActivity extends Activity{
	
	private ArrayList<Beauty> beautyList;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		if(beautyList == null){
			beautyList = new ArrayList<Beauty>();
		}
		
		doMyMission();
		
		setupViews();
	}
	
	private void doMyMission(){
		try {
			AssetManager as = this.getAssets();
			InputStream is = as.open("beauties.xml");
			InputSource is2 = new InputSource(is);
			SAXParserFactory spf = SAXParserFactory.newInstance();
			SAXParser sp = spf.newSAXParser();
			XMLReader xr = sp.getXMLReader();
			MySaxHandler msh = new MySaxHandler(beautyList);
			xr.setContentHandler(msh);
			xr.parse(is2);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	private void setupViews(){
		String result = "";
		
		for (Beauty b : beautyList) {  
            result += b.toString();  
        }  
 
        TextView textView = (TextView) findViewById(R.id.textView);  
        textView.setText(result); 
	}
 
}