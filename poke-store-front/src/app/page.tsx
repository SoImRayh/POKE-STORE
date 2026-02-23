import Link from "next/link";
import SelectTheme from "./components/SelectTheme";

export default function Home() {
  return (
    <body className="">
      <div className="navbar shadow-sm">
        <div className="flex-1">
          <a href="" className="btn btn-ghost text-xl">RAYH SHOP</a>
        </div>
        <div className="flex-none">
          <Link href="/login" className="btn btn-primary btn-square px-10">LOGIN</Link>
        </div>
      </div>

    </body>
  );
}
