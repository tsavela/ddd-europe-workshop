namespace App.CommandsHandlers
{
    public class BecomeFriendOfUserCommandHandler
    {
        /*
            This is where we handle the BecomeFriendOfUser command.
        */

        /*
            STEP (1)
            Use the User Repository to retrive the domain objects which represents the source user and the target user.
        */

        /*
            STEP (2)
            Apply the friendship on both domain objects.
            Here you should expect an error to be thrown if a business rule gets violated.
        */

        /*
            STEP (3)
            Use the User Repository to persist the modified domain objects.
        */

        /*
            STEP (4)
            Propogate the change by returning an event.
        */
    }
}