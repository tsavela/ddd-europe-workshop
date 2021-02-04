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

        void UserSharedPost(string postId, string userId)
        {
        }
    }
}