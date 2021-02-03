using System;
using System.Linq;
using App.Views;
using FluentAssertions;
using Xunit;

namespace App.Tests
{
    public class SocialGraphTests
    {
        [Fact]
        public void Connections_ShouldReturnCorrectNumberOfEdges()
        {
            var graph = new SocialGraph();
            graph.AddPerson("A");
            graph.AddPerson("B");
            graph.AddPerson("C");
            graph.AddPerson("D");
            graph.CreateFriendship("A", "B");
            graph.CreateFriendship("B", "C");
            graph.CreateFriendship("A", "D");

            var connections = graph.GetConnections("A", "C");

            connections.Count().Should().Be(2);

        }
    }
}