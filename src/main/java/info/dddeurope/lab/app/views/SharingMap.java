package info.dddeurope.lab.app.views;

import java.util.HashMap;
import java.util.Map;

public class SharingMap {

    Map<String, String[]> postToUsers;
    
    public SharingMap() {
        this.postToUsers = new HashMap<>();
    }

    void userSharedPost(String postId, String userId) {
        //this.postToUsers.get(postId);
    }

}
