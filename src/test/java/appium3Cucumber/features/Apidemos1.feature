Feature: Api Demos Scenarios


  Scenario: Popup menu assertion

    Given user opens APIDEMO on SAMSUNG_A33
    When  user clicks "API Demos"
    And   user clicks "View"
    And   user clicks "Popup Menu"
    And   user clicks "MAKE A POPUP!"
    Then  "Add" should be visible
    When  user clicks "Add"
    Then  "Clicked popup menu item Add" should be visible




    # API DEMOS -> Views -> Popup Menu
    # MAKE A POPUP! tikla
    # Menunun acildigini assert et
    # Add e tikla
    # Notification'i assert edelim
