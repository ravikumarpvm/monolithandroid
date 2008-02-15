package org.teacake.monolith;

import android.app.Activity;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.Menu;

public class Monolith extends Activity
{
    
    
	public static final int GAME_CLASSIC = 0;
	public static final int GAME_MONOLITH = 1;
    GLView view;
    OptionsView optionsView;
    
 
    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle icicle) {
        super.onCreate(icicle);

        view = new GLView( getApplication(),GAME_MONOLITH );
        view.setViewType(GLView.VIEW_INTRO);
        view.doInit();
        view.running=true;
        optionsView = new OptionsView(getApplication());
        android.content.AssetManager mgr = getApplication().getAssets();
        //String[] assetlist=null;
        /*
        String message = "->";
        try
        {
        	assetlist = mgr.list("/");
        	if (assetlist!=null)
        	{
        		for(int i=0;i<assetlist.length;i++)
        		{
        			message+=assetlist[i]+"{";
        		}
        		view.message = message;
        	}
        }
        catch(Exception e)
        {
        	
        }
        */
        
        setContentView(view);
         
    }
    
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        super.onCreateOptionsMenu(menu);

        
        menu.add(0, 0, R.string.m_new_monolith, new Runnable() {
            public void run() {
                //mLunarView.doStart();


            	view = new GLView( getApplication(),GAME_MONOLITH );
                view.setViewType(GLView.VIEW_GAME);
                view.doInit();
                view.running=true;
                optionsView = new OptionsView(getApplication());
                setContentView(view);
            	
            	
            }
        });
        
        menu.add(1, 0, R.string.m_new_classic, new Runnable() {
            public void run() {
                //mLunarView.doStart();


            	view = new GLView( getApplication(),GAME_CLASSIC );
                view.setViewType(GLView.VIEW_GAME);
                view.doInit();
                view.running=true;
                optionsView = new OptionsView(getApplication());
                setContentView(view);
            	
            	
            }
        });       
        /*
		menu.add(2, 0, R.string.m_m_options, new Runnable()
		{
			public void run() {
				setContentView(R.layout.options);
			}
			
		});*/
		menu.add(2, 0, R.string.s_exit_game, new Runnable()
		{
			public void run() {
				view.performCleanup();
				finish();
			}
			
		});
		
		
		
		

        
        
        /*
        menu.add(0, 0, R.string.menu_stop, new Runnable() {
            public void run() {
                mLunarView.setMode(LunarView.LOSE, LunarLander.this.
                        getText(R.string.message_stopped));
            }
        });


        menu.add(0, 0, R.string.menu_pause, new Runnable() {
            public void run() {
                mLunarView.doPause();
            }
        });

        menu.add(0, 0, R.string.menu_resume, new Runnable() {
            public void run() {
                mLunarView.doResume();
            }
        });

        menu.addSeparator(0, 0);

        menu.add(0, 0, R.string.menu_easy, new Runnable() {
            public void run() {
                mLunarView.setDifficulty(LunarView.EASY);
            }
        });

        menu.add(0, 0, R.string.menu_medium, new Runnable() {
            public void run() {
                mLunarView.setDifficulty(LunarView.MEDIUM);
            }
        });

        menu.add(0, 0, R.string.menu_hard, new Runnable() {
            public void run() {
                mLunarView.setDifficulty(LunarView.HARD);
            }
        });
		*/
        return true;
    }   
    
    @Override
    public boolean onKeyDown(int keyCode, KeyEvent msg) {
        boolean handled = false;
        if(view.game!=null)
        {
        	if (view.game.getStatus()!= SimpleGameData.STATUS_PLAYING)
        	{
        		return handled;
        	}
        }
        if (keyCode == KeyEvent.KEYCODE_DPAD_DOWN)
        {
        	view.doMoveDown();
        	handled = true;
        }
        if(keyCode == KeyEvent.KEYCODE_DPAD_LEFT)
        {
        	view.doMoveLeft();
        	handled = true;
        }
        if(keyCode == KeyEvent.KEYCODE_DPAD_RIGHT)
        {
        	view.doMoveRight();
        	handled = true;
        }
        if(keyCode == KeyEvent.KEYCODE_SPACE || keyCode == KeyEvent.KEYCODE_DPAD_UP)
        {
        	view.doRotateBlock();
        	handled = true;
        }
        /*
        if(keyCode == KeyEvent.KEYCODE_ENDCALL)
        {
        	this.finish();
        	handled = true;
        }
        */
        return handled;
    }

    /**
     * Standard override for key-up. We actually care about these,
     * so we can turn off the engine or stop rotating.
     */
    @Override
    public boolean onKeyUp(int keyCode, KeyEvent msg) {
        boolean handled = false;
        /*
        if (mMode == RUNNING) {
            if (keyCode == KeyEvent.KEYCODE_DPAD_CENTER ||
                keyCode == KeyEvent.KEYCODE_SPACE) {
                setFiring(false);
                handled = true;
            } else if (keyCode == KeyEvent.KEYCODE_DPAD_LEFT ||
                       keyCode == KeyEvent.KEYCODE_Q || 
                       keyCode == KeyEvent.KEYCODE_DPAD_RIGHT ||
                       keyCode == KeyEvent.KEYCODE_W) {
                mRotating = 0;
                handled = true;
            }
        }
		*/
        return handled;
    }
    

    
     
}