Feature: Api Demos Scenarios



  Scenario: Popup menu assertion

    Given user clicks "API Demos"
    And   user clicks "Views"
    And   swipe until the text "Popup Menu" is visible
    And   user clicks "Popup Menu"
    And   user clicks "MAKE A POPUP!"
    Then  "Add" should be visible
    When  user clicks "Add"
    Then  "Clicked" should be visible




    # API DEMOS -> Views -> Popup Menu
    # MAKE A POPUP! tikla
    # Menunun acildigini assert et
    # Add e tikla
    # Notification'i assert edelim
