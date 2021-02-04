using App.Events;
using App.Views;

namespace App.EventHandlers
{
    public class UserRegisteredEventHandler
    {
        private readonly SocialGraph _socialGraph;

        public UserRegisteredEventHandler(SocialGraph socialGraph)
        {
            _socialGraph = socialGraph;
        }

        public void Handle(UserRegisteredEvent evt)
        {
            _socialGraph.AddPerson(evt.UserId);
        }
    }
}