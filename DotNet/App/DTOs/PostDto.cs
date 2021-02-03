
//import lombok.AllArgsConstructor;
//import lombok.Data;

//@Data
//@AllArgsConstructor
namespace App.DTOs
{
    public record PostDto(string PublisherId, string Title, string Body, int MinAge);
}
