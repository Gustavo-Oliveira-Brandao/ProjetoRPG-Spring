package com.gustavo.projeto.rpg.models;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import org.hibernate.validator.constraints.Length;

import java.util.Objects;

@Entity
public class Attack {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "attack_id")
    private Long id;

    @NotNull
    @Length(max = 100)
    @Column(length = 100, nullable = false)
    private String name;

    @NotNull
    @Length(max = 50)
    @Column(length = 50, nullable = false)
    private String attackRange;

    @NotNull
    @Length(max = 50)
    @Column(length = 50, nullable = false)
    private String toHitSkill;

    @NotNull
    @Column(nullable = false)
    private Integer toHit;

    @NotNull
    @Column(nullable = false)
    private Integer toHitBonus;

    @NotNull
    @Column(nullable = false)
    private Integer critMultiplier;

    @NotNull
    @Column(nullable = false)
    private Integer critMargin;

    @Length(max = 500)
    @Column(length = 500)
    private String description;

    @NotNull
    @Column(nullable = false)
    private Integer damageQuantity1;

    @NotNull
    @Column(nullable = false)
    private Integer damageDiceSize1;

    @NotNull
    @Length(max = 50)
    @Column(nullable = false, length = 50)
    private String damageType1;

    @NotNull
    @Column(nullable = false)
    private Integer bonusDamage1;

    @NotNull
    @Length(max = 50)
    @Column(nullable = false, length = 50)
    private String damageAttribute1;

    @NotNull
    @Column(nullable = false)
    private Integer damageQuantity2;

    @NotNull
    @Column(nullable = false)
    private Integer damageDiceSize2;

    @NotNull
    @Length(max = 50)
    @Column(nullable = false, length = 50)
    private String damageType2;

    @NotNull
    @Column(nullable = false)
    private Integer bonusDamage2;

    @NotNull
    @Length(max = 50)
    @Column(nullable = false, length = 50)
    private String damageAttribute2;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "rpg_character_id")
    private RpgCharacter rpgCharacter;

    public Attack(){}

    public Attack(String name, String attackRange, String toHitSkill, Integer toHit, Integer toHitBonus, Integer critMultiplier, Integer critMargin, String description, Integer damageQuantity1, Integer damageDiceSize1, String damageType1, Integer bonusDamage1, String damageAttribute1, Integer damageQuantity2, Integer damageDiceSize2, String damageType2, Integer bonusDamage2, String damageAttribute2) {
        this.name = name;
        this.attackRange = attackRange;
        this.toHitSkill = toHitSkill;
        this.toHit = toHit;
        this.toHitBonus = toHitBonus;
        this.critMultiplier = critMultiplier;
        this.critMargin = critMargin;
        this.description = description;
        this.damageQuantity1 = damageQuantity1;
        this.damageDiceSize1 = damageDiceSize1;
        this.damageType1 = damageType1;
        this.bonusDamage1 = bonusDamage1;
        this.damageAttribute1 = damageAttribute1;
        this.damageQuantity2 = damageQuantity2;
        this.damageDiceSize2 = damageDiceSize2;
        this.damageType2 = damageType2;
        this.bonusDamage2 = bonusDamage2;
        this.damageAttribute2 = damageAttribute2;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAttackRange() {
        return attackRange;
    }

    public void setAttackRange(String attackRange) {
        this.attackRange = attackRange;
    }

    public String getAttackDescription() {
        return description;
    }

    public void setAttackDescription(String description) {
        this.description = description;
    }

    public String getToHitSkill() {
        return toHitSkill;
    }

    public void setToHitSkill(String toHitSkill) {
        this.toHitSkill = toHitSkill;
    }

    public Integer getToHit() {
        return toHit;
    }

    public void setToHit(Integer toHit) {
        this.toHit = toHit;
    }

    public Integer getToHitBonus() {
        return toHitBonus;
    }

    public void setToHitBonus(Integer toHitBonus) {
        this.toHitBonus = toHitBonus;
    }

    public Integer getCritMultiplier() {
        return critMultiplier;
    }

    public void setCritMultiplier(Integer critMultiplier) {
        this.critMultiplier = critMultiplier;
    }

    public Integer getCritMargin() {
        return critMargin;
    }

    public void setCritMargin(Integer critMargin) {
        this.critMargin = critMargin;
    }

    public Integer getDamageQuantity1() {
        return damageQuantity1;
    }

    public void setDamageQuantity1(Integer damageQuantity1) {
        this.damageQuantity1 = damageQuantity1;
    }

    public Integer getDamageDiceSize1() {
        return damageDiceSize1;
    }

    public void setDamageDiceSize1(Integer damageDiceSize1) {
        this.damageDiceSize1 = damageDiceSize1;
    }

    public String getDamageType1() {
        return damageType1;
    }

    public void setDamageType1(String damageType1) {
        this.damageType1 = damageType1;
    }

    public Integer getBonusDamage1() {
        return bonusDamage1;
    }

    public void setBonusDamage1(Integer bonusDamage1) {
        this.bonusDamage1 = bonusDamage1;
    }

    public String getDamageAttribute1() {
        return damageAttribute1;
    }

    public void setDamageAttribute1(String damageAttribute1) {
        this.damageAttribute1 = damageAttribute1;
    }

    public Integer getDamageQuantity2() {
        return damageQuantity2;
    }

    public void setDamageQuantity2(Integer damageQuantity2) {
        this.damageQuantity2 = damageQuantity2;
    }

    public Integer getDamageDiceSize2() {
        return damageDiceSize2;
    }

    public void setDamageDiceSize2(Integer damageDiceSize2) {
        this.damageDiceSize2 = damageDiceSize2;
    }

    public String getDamageType2() {
        return damageType2;
    }

    public void setDamageType2(String damageType2) {
        this.damageType2 = damageType2;
    }

    public Integer getBonusDamage2() {
        return bonusDamage2;
    }

    public void setBonusDamage2(Integer bonusDamage2) {
        this.bonusDamage2 = bonusDamage2;
    }

    public String getDamageAttribute2() {
        return damageAttribute2;
    }

    public void setDamageAttribute2(String damageAttribute2) {
        this.damageAttribute2 = damageAttribute2;
    }

    public RpgCharacter getCharacter() {
        return rpgCharacter;
    }

    public void setCharacter(RpgCharacter rpgCharacter) {
        this.rpgCharacter = rpgCharacter;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Attack attack)) return false;
        return Objects.equals(id, attack.id) && Objects.equals(name, attack.name) && Objects.equals(attackRange, attack.attackRange) && Objects.equals(toHitSkill, attack.toHitSkill) && Objects.equals(toHit, attack.toHit) && Objects.equals(toHitBonus, attack.toHitBonus) && Objects.equals(critMultiplier, attack.critMultiplier) && Objects.equals(critMargin, attack.critMargin) && Objects.equals(description, attack.description) && Objects.equals(damageQuantity1, attack.damageQuantity1) && Objects.equals(damageDiceSize1, attack.damageDiceSize1) && Objects.equals(damageType1, attack.damageType1) && Objects.equals(bonusDamage1, attack.bonusDamage1) && Objects.equals(damageAttribute1, attack.damageAttribute1) && Objects.equals(damageQuantity2, attack.damageQuantity2) && Objects.equals(damageDiceSize2, attack.damageDiceSize2) && Objects.equals(damageType2, attack.damageType2) && Objects.equals(bonusDamage2, attack.bonusDamage2) && Objects.equals(damageAttribute2, attack.damageAttribute2) && Objects.equals(rpgCharacter, attack.rpgCharacter);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, attackRange, toHitSkill, toHit, toHitBonus, critMultiplier, critMargin, description, damageQuantity1, damageDiceSize1, damageType1, bonusDamage1, damageAttribute1, damageQuantity2, damageDiceSize2, damageType2, bonusDamage2, damageAttribute2, rpgCharacter);
    }
}
