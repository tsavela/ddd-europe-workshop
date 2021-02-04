using App.Events;

namespace App.EventHandlers
{
    public class UsersBecameFriendsEventHandler
    {
        public void Handle(UsersBecameFriendsEvent evt)
        {
            // Update the relevant denormalized data-stores (views) to project the event.
        }
    }
}