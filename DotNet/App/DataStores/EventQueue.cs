using System.Collections.Generic;
using App.Common;

namespace App.DataStores
{
    public class EventQueue
    {
        private readonly Dictionary<string, List<IEvent>> _store = new();

        public void AddEvent(string id, IEvent evt) {
            if (!_store.TryGetValue(id, out var events)) {
                events = new List<IEvent> {evt};
                _store[id] = events;
            } else {
                events.Add(evt);
            }
        }

        public List<IEvent> GetEvents(string id)
        {
            return _store.TryGetValue(id, out var events) ? events : null;
        }
    }
}