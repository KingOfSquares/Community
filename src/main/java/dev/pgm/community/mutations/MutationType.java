package dev.pgm.community.mutations;

public enum MutationType {
  RAGE("Rage", "Instant death"),
  BLITZ("Blitz", "A limited number of lives"),
  TNTRAIN("TNT Rain", "Raining TNT death from above..."),
  FLY("Fly", "Everyone can fly"),
  JUMP("Jump", "Double jump");

  String displayName;
  String description;

  MutationType(String displayName, String description) {
    this.displayName = displayName;
    this.description = description;
  }

  public String getDisplayName() {
    return displayName;
  }

  public String getDescription() {
    return description;
  }
}
