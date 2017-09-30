package phaseshift.com.demophase.Events;

import android.content.Context;

import phaseshift.com.demophase.Events.Model.Data;

/**
 * Created by Shivam on 24-07-2017.
 */

public interface EventsRouter {
    public void goToMaps(Context context);
    public void goToAboutBMS(Context context);
    public void goToTeam(Context context);
    public void goToAboutPS(Context context);
    public void goToEvents(Context context);
    public void goToEventDetails(Context context, Data event);
    public void goToDeveloper(Context context);
}
