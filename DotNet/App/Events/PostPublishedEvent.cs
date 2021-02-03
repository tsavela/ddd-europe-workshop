using App.DTOs;

namespace App.Events
{
    public record PostPublishedEvent(string PostId, PostDto PostDto);
}