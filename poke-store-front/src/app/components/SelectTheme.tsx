"use client";
import { useTheme } from "next-themes";

const SelectTheme = () => {
  const { theme, setTheme } = useTheme();

  return (
    <div className="flex flex-col gap-4">
      The current theme is: {theme}
      <button onClick={() => setTheme("light")}>Light Mode</button>
      <button onClick={() => setTheme("dark")}>Dark Mode test</button>
    </div>
  );
};

export default SelectTheme;
