package com.example.model;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.util.ArrayList;
import java.util.List;
import javax.validation.Valid;
import javax.validation.constraints.*;

/**
 * UpdateMovie
 */
@javax.annotation.Generated(value = "io.swagger.codegen.languages.SpringCodegen", date = "2017-10-15T23:45:57.158+02:00")

public class UpdateMovie   {
  @JsonProperty("title")
  private String title = null;

  @JsonProperty("year")
  private Integer year = null;

  @JsonProperty("actors")
  private List<Integer> actors = null;

  public UpdateMovie title(String title) {
    this.title = title;
    return this;
  }

   /**
   * Get title
   * @return title
  **/
  @ApiModelProperty(value = "")


  public String getTitle() {
    return title;
  }

  public void setTitle(String title) {
    this.title = title;
  }

  public UpdateMovie year(Integer year) {
    this.year = year;
    return this;
  }

   /**
   * Get year
   * @return year
  **/
  @ApiModelProperty(value = "")


  public Integer getYear() {
    return year;
  }

  public void setYear(Integer year) {
    this.year = year;
  }

  public UpdateMovie actors(List<Integer> actors) {
    this.actors = actors;
    return this;
  }

  public UpdateMovie addActorsItem(Integer actorsItem) {
    if (this.actors == null) {
      this.actors = new ArrayList<Integer>();
    }
    this.actors.add(actorsItem);
    return this;
  }

   /**
   * Get actors
   * @return actors
  **/
  @ApiModelProperty(value = "")


  public List<Integer> getActors() {
    return actors;
  }

  public void setActors(List<Integer> actors) {
    this.actors = actors;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    UpdateMovie updateMovie = (UpdateMovie) o;
    return Objects.equals(this.title, updateMovie.title) &&
        Objects.equals(this.year, updateMovie.year) &&
        Objects.equals(this.actors, updateMovie.actors);
  }

  @Override
  public int hashCode() {
    return Objects.hash(title, year, actors);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class UpdateMovie {\n");
    
    sb.append("    title: ").append(toIndentedString(title)).append("\n");
    sb.append("    year: ").append(toIndentedString(year)).append("\n");
    sb.append("    actors: ").append(toIndentedString(actors)).append("\n");
    sb.append("}");
    return sb.toString();
  }

  /**
   * Convert the given object to string with each line indented by 4 spaces
   * (except the first line).
   */
  private String toIndentedString(java.lang.Object o) {
    if (o == null) {
      return "null";
    }
    return o.toString().replace("\n", "\n    ");
  }
}

