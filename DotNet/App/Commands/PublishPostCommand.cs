using App.DTOs;

namespace App.Commands
{
    public record PublishPostCommand(string PostId, PostDto PostDto);
}