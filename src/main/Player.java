import com.github.geezgus.datastructure.ArrayList;

public class Player {

    private final ArrayList<PlayerField> fields = new ArrayList<>(91);

    public Player() {
        fields.add(new PlayerField("id", null));
        fields.add(new PlayerField("name", null));
        fields.add(new PlayerField("full_name", null));
        fields.add(new PlayerField("birth_date", null));
        fields.add(new PlayerField("age", null));
        fields.add(new PlayerField("height_cm", null));
        fields.add(new PlayerField("weight_kgs", null));
        fields.add(new PlayerField("positions", null));
        fields.add(new PlayerField("nationality", null));
        fields.add(new PlayerField("overall_rating", null));
        fields.add(new PlayerField("potential", null));
        fields.add(new PlayerField("value_euro", null));
        fields.add(new PlayerField("wage_euro", null));
        fields.add(new PlayerField("preferred_foot", null));
        fields.add(new PlayerField("international_reputation(1-5)", null));
        fields.add(new PlayerField("weak_foot(1-5)", null));
        fields.add(new PlayerField("skill_moves(1-5)", null));
        fields.add(new PlayerField("work_rate", null));
        fields.add(new PlayerField("body_type", null));
        fields.add(new PlayerField("release_clause_euro", null));
        fields.add(new PlayerField("club_team", null));
        fields.add(new PlayerField("club_rating", null));
        fields.add(new PlayerField("club_position", null));
        fields.add(new PlayerField("club_jersey_number", null));
        fields.add(new PlayerField("club_join_date", null));
        fields.add(new PlayerField("contract_end_year", null));
        fields.add(new PlayerField("national_team", null));
        fields.add(new PlayerField("national_rating", null));
        fields.add(new PlayerField("national_team_position", null));
        fields.add(new PlayerField("national_jersey_number", null));
        fields.add(new PlayerField("crossing", null));
        fields.add(new PlayerField("finishing", null));
        fields.add(new PlayerField("heading_accuracy", null));
        fields.add(new PlayerField("short_passing", null));
        fields.add(new PlayerField("volleys", null));
        fields.add(new PlayerField("dribbling", null));
        fields.add(new PlayerField("curve", null));
        fields.add(new PlayerField("freekick_accuracy", null));
        fields.add(new PlayerField("long_passing", null));
        fields.add(new PlayerField("ball_control", null));
        fields.add(new PlayerField("acceleration", null));
        fields.add(new PlayerField("sprint_speed", null));
        fields.add(new PlayerField("agility", null));
        fields.add(new PlayerField("reactions", null));
        fields.add(new PlayerField("balance", null));
        fields.add(new PlayerField("shot_power", null));
        fields.add(new PlayerField("jumping", null));
        fields.add(new PlayerField("stamina", null));
        fields.add(new PlayerField("strength", null));
        fields.add(new PlayerField("long_shots", null));
        fields.add(new PlayerField("aggression", null));
        fields.add(new PlayerField("interceptions", null));
        fields.add(new PlayerField("positioning", null));
        fields.add(new PlayerField("vision", null));
        fields.add(new PlayerField("penalties", null));
        fields.add(new PlayerField("composure", null));
        fields.add(new PlayerField("marking", null));
        fields.add(new PlayerField("standing_tackle", null));
        fields.add(new PlayerField("sliding_tackle", null));
        fields.add(new PlayerField("GK_diving", null));
        fields.add(new PlayerField("GK_handling", null));
        fields.add(new PlayerField("GK_kicking", null));
        fields.add(new PlayerField("GK_positioning", null));
        fields.add(new PlayerField("GK_reflexes", null));
        fields.add(new PlayerField("tags", null));
        fields.add(new PlayerField("traits", null));
        fields.add(new PlayerField("LS", null));
        fields.add(new PlayerField("ST", null));
        fields.add(new PlayerField("RS", null));
        fields.add(new PlayerField("LW", null));
        fields.add(new PlayerField("LF", null));
        fields.add(new PlayerField("CF", null));
        fields.add(new PlayerField("RF", null));
        fields.add(new PlayerField("RW", null));
        fields.add(new PlayerField("LAM", null));
        fields.add(new PlayerField("CAM", null));
        fields.add(new PlayerField("RAM", null));
        fields.add(new PlayerField("LM", null));
        fields.add(new PlayerField("LCM", null));
        fields.add(new PlayerField("CM", null));
        fields.add(new PlayerField("RCM", null));
        fields.add(new PlayerField("RM", null));
        fields.add(new PlayerField("LWB", null));
        fields.add(new PlayerField("LDM", null));
        fields.add(new PlayerField("CDM", null));
        fields.add(new PlayerField("RDM", null));
        fields.add(new PlayerField("RWB", null));
        fields.add(new PlayerField("LB", null));
        fields.add(new PlayerField("LCB", null));
        fields.add(new PlayerField("CB", null));
        fields.add(new PlayerField("RCB", null));
        fields.add(new PlayerField("RB", null));
    }

    public Player setField(String name, String value) {
        for (int i = 0; i < fields.size(); i++) {
            if (fields.get(i).fieldName.equals(name)) {
                fields.get(i).fieldValue = value;
                break;
            }
        }
        return this;
    }

    public String getField(String name) {
        for (int i = 0; i < fields.size(); i++) {
            if (fields.get(i).fieldName.equals(name)) {
                return fields.get(i).fieldValue;
            }
        }
        return null;
    }

    public ArrayList<PlayerField> getFields() {
        return fields;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("Player={");

        for (int i = 0; i < getFields().size(); i++) {
            sb.append(getFields().get(i).fieldName).append(": ");

            if (getFields().get(i).fieldValue == null) {
                sb.append(getFields().get(i).fieldValue);
            } else {
                sb.append("'").append(getFields().get(i).fieldValue).append("'");
            }

            sb.append(", ");
        }

        return sb.append("\b\b}").toString();
    }

    final static class PlayerField {
        String fieldName;
        String fieldValue;

        public PlayerField(String fieldName, String fieldValue) {
            this.fieldName = fieldName;
            this.fieldValue = fieldValue;
        }
    }
}
