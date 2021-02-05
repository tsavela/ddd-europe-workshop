using System.Collections.Generic;

namespace App.Views
{
    public class SharingMap
    {
        Dictionary<string, string[]> _postToUsers;

        public SharingMap()
        {
            _postToUsers = new Dictionary<string, string[]>();
        }

        public void UserSharedPost(string postId, string userId)
        {
        }

        public string[] GetUsersThatSharedPost(string postId)
        {
            return new string[0];
        }
    }
}