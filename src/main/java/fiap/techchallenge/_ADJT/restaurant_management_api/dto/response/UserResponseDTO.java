package fiap.techchallenge._ADJT.restaurant_management_api.dto.response;

import fiap.techchallenge._ADJT.restaurant_management_api.entity.User;
import fiap.techchallenge._ADJT.restaurant_management_api.enums.UserType;

public record UserResponseDTO(
        Long id,
        String name,
        String email,
        String username,
        UserType type,
        String updatedAt) {
    public static UserResponseDTO fromEntity(User user) {
        return new UserResponseDTO(
                user.getId(),
                user.getName(),
                user.getEmail(),
                user.getUsername(),
                user.getType(),
                user.getFormattedUpdatedAt()
        );

    }
}
