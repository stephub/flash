package com.test.flash;

import android.hardware.Camera;
import android.hardware.Camera.Parameters;
import android.os.Bundle;
import android.app.Activity;

public class FlashActivity extends Activity {

	Camera camera;
	boolean isOpen;
	
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_flash);
        isOpen = true;
        turnFlash();
    }
    
    private void turnFlash() {
    	try {
	    	if(isOpen) {
	    		camera = Camera.open();
	            Parameters params = camera.getParameters();
	            params.setFlashMode(Parameters.FLASH_MODE_TORCH);
	            camera.setParameters(params);
	            camera.startPreview();
	            isOpen = false;
	    	} else {
	    		camera.stopPreview();
	    		camera.release();
	    		isOpen = true;
	    	}
    	} catch (Exception e) {
    		//
    	}
    }

	@Override
	protected void onDestroy() {
		super.onDestroy();
		isOpen = false;
		turnFlash();
	}
    
    
}
