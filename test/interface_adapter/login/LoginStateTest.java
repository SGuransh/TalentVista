package interface_adapter.login;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class LoginStateTest {
    private LoginState state;
    @BeforeEach
    void init(){
        state = new LoginState();
        state = new LoginState(state);
    }

    @Test
    void getUsername() {
        assertEquals(state.getUsername(), "");
        state.setUsername("taha");
        assertEquals(state.getUsername(), "taha");
    }

    @Test
    void getUsernameError() {
        assertNull(state.getUsernameError());
        state.setUsernameError("error1");
        assertEquals(state.getUsernameError(), "error1");
    }

    @Test
    void getPassword() {
        assertEquals(state.getPassword(), "");
        state.setPassword("admin");
        assertEquals(state.getPassword(), "admin");
    }

    @Test
    void getPasswordError() {
        assertNull(state.getPasswordError());
        state.setPasswordError("error2");
        assertEquals(state.getPasswordError(), "error2");
    }

}