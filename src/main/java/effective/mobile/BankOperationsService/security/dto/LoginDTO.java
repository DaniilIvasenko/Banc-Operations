package effective.mobile.BankOperationsService.security.dto;

import lombok.Data;


public record LoginDTO(
        String username,
        String password) {
}