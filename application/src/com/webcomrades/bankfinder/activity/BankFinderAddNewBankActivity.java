package com.webcomrades.bankfinder.activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;

import com.webcomrades.bankfinder.R;

public class BankFinderAddNewBankActivity extends BankFinderActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_addbank);
    }
	
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		MenuInflater inflater = getMenuInflater();
		inflater.inflate(R.menu.menu_addbank, menu);
		initMenuLoader(menu);
		return super.onCreateOptionsMenu(menu);
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		if (item.getItemId() == R.id.menu_add) {
			startActivity(new Intent(this, BankFinderAddNewBankActivity.class));
			return true;
		} else {
			return super.onOptionsItemSelected(item);
		}
	}
    
}