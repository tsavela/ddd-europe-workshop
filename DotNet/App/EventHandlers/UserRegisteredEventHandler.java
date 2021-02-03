package info.dddeurope.lab.app.eventHandlers;

//import info.dddeurope.lab.app.events.UserRegisteredEvent;
//import info.dddeurope.lab.app.views.SocialGraph;
//import lombok.AllArgsConstructor;
//import lombok.Data;

/* 
    Event handlers projects an event onto the relevant denormelized data-stores.
    Here, we update the social graph upon a user registration. 
*/

//@Data
//@AllArgsConstructor
public class UserRegisteredEventHandler {

    private SocialGraph socialGraph;

    public void handle(UserRegisteredEvent event) throws Exception {
        socialGraph.addPerson(event.getUserId());
    }  

}
